
##Download and install docker


##Download docker image (otherwise done automagically in run step)
docker pull jenkinsci/blueocean

##Start container
sudo docker run -v /var/run/docker.sock:/var/run/docker.sock -p 8080:8080 -p 5000:3000 -u root -d --name jenkins jenkinsci/blueocean

-v /var/run/docker.sock:/var/run/docker.sock    makes it possible to run "docker" command from inside container
-p 8080:8080 -p 5000:3000                       exposes port 8080 and maps 3000 to 5000. If this is omitted services wont be accessible outside the container.
--name jenkins                                  sets the name of the container to jenkins (can be anything)
-d                                              detaches 
-u root                                         log in to container as root user. temporary hack to be able to use docker commmands.

##Setup Jenkins
Go to localhost:8080. You will be asked for the admin password. Folder in container where it is located is given.
Log in to the container: "docker exec -it jenkins bash". Go to the /var/ directory asked for above to get password.

After password is entered you may setup the admin user.

##Add github projects
Switch to "blue ocean" in meny and then "create new pipeline".
You will need an access token to the repo you´re using, the repository admin has it.

##Run jenkins job
The job might start automatically the first time. Verify that it is working.

##Docker commands

docker ps //lists all running containers. add -a flag to list stopped ones.
docker images //lists all downloaded images
docker rm <container> //remove <container>
docker rmi <image> //remove <image>
docker build -t <newImage> . //builds new image from a Dockerfile (name set with -t)
