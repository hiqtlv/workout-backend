echo "starting awesome react docker deployment script"
echo "start by building new backend java image"

docker stop workout-back

docker build -t workout-rest .

echo "start new rest container"

JENKINS_NODE_COOKIE=dontkillme2 docker run -d  \
  --name workout-back \
  -p 8082:8081 \
  --rm \
  workout-rest
