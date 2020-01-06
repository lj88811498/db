node {
  // 代码检出
  stage('get Code') {
    sh "echo '拉取git代码'"
    git credentialsId: '044b03b3-a2fd-4958-b3dd-49b3fc37df7b', url: 'http://GitLab.cdyoue.com/lijiang/nncloud.git'
  }

    // 镜像中进行单元测试
  stage('rename tag'){
    sh '''
    echo '停止镜像开始……'
    CID=`docker ps -a | grep 'nncloud:2.0' | awk '{print $1}'|cut -d/ -f1`
    [ -n "$CID" ] && echo "如果CID不为空，打印CID：" $CID && echo '开始停止镜像' && docker stop $CID && echo '开始删除容器' && docker rm $CID && echo '开始删除镜像' && docker rmi 'nncloud:2.0' && echo 'over~!'
    echo '镜像处理结束'
     '''
  }
  // 镜像中代码构建
  stage('Build'){

    sh 'mvn clean package docker:build'
  }

  // start
  stage("start"){

      sh 'docker run -d -p 8887:8899 -v /usr/share/zoneinfo/Asia/Shanghai:/etc/timezone:ro -v /etc/localtime:/etc/localtime:ro  -v /var/www/html/nanning:/var/www/html/nanning nncloud:2.0'
  }


}