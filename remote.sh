#!/bin/bash

echo "------开始执行脚本------"

{
    docker stop app-market-server
    original=$(docker ps -a | grep "app-market-server" | awk '{print $2}')
    docker rm app-market-server
    echo 'app-market-server 原容器删除完成'
} || {
    echo 'app-market-server 原容器删除异常'
}

echo '-----启动新镜像-----'
docker run --restart=always -e 'SPRING_PROFILES_ACTIVE=dev' -v /etc/localtime:/etc/localtime:ro --name app-market-server -d -p 1401:1401 app-market-api:1.0-SNAPSHOT
if [ $? -eq 0 ]
then

    docker rmi $original
    echo '------删除原镜像成功------'
else
    echo '-----启动新镜像失败，开始回滚-----'
    docker rmi $(docker images | grep "app-market-api" | awk '{print $3}')
    docker tag $original app-market-api:1.0-SNAPSHOT
    docker run --restart=always -e 'SPRING_PROFILES_ACTIVE=dev' -v /etc/localtime:/etc/localtime:ro --name app-market-server -d -p 1401:1401 app-market-api:1.0-SNAPSHOT
    echo '-----回滚成功-----'
    exit 1
fi
echo '-----新镜像启动成功-----'
echo "执行成功 $original"