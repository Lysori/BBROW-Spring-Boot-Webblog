## Ubuntu 20.04 LTS


### Jenkins
```
sudo service jenkins start
```

### Docker farm
```
docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=root -d mysql
docker run -d --network tools -p 8081:8081 --name nexus sonatype/nexus
docker run -it --rm -p 8888:8080 tomcat
```

### GitHub, SSH and Jenkins
```
ssh-keygen -t rsa

```
Add public key to GitHub profile
Add private key to Jenkins credentials

Docker Plugin in Jenkins

```
sudo usermod -aG docker ${USER}
```

or

```
sudo chmod 777 /var/run/docker.sock
```

Remove Spotify dependencies

```
docker network create tools
docker network create app
```

Add hosted repository to Nexus

```
                <altDeploymentRepository>nexus-snapshots::default::http://${NEXUS_HOST}/nexus/content/repositories/nexus-snapshots</altDeploymentRepository>
                <altSnapshotDeploymentRepository>nexus-snapshots::default::http://${NEXUS_HOST}/nexus/content/repositories/nexus-snapshots</altSnapshotDeploymentRepository>
                <altReleaseDeploymentRepository>nexus-releases::default::http://${NEXUS_HOST}/nexus/content/repositories/nexus-releases</altReleaseDeploymentRepository>
```





