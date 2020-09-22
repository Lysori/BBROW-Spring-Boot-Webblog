## Ubuntu 20.04 LTS


### Jenkins
```
sudo service jenkins start
```

### Docker farm
```
docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=root -d mysql
docker run -d -p 8081:8081 --name nexus sonatype/nexus
docker run -it --rm -p 8888:8080 tomcat
```

### GitHub, SSH and Jenkins
```
ssh-keygen -t rsa

```
Add public key to GitHub profile
Add private key to Jenkins credentials

Docker Plugin in Jenkins
