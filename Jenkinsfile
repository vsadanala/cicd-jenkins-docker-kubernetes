//DECLARATIVE
pipeline {
environment {
dockerHome = tool 'myDocker'
mavenHome = tool 'myMaven'    
registry = "arundhwaj/hello-world-jenkins"
registryCredential = 'dockerhub'
dockerImage = ''
}
agent any
stages {
stage('Cloning our Git') {
steps {
git 'https://github.com/ArunDhwaj/hello-world-jenkins'
}
}
stage('Building our image') {
steps{
script {
dockerImage = docker.build registry + ":$BUILD_NUMBER"
}
}
}
stage('Deploy our image') {
steps{
script {
docker.withRegistry( '', registryCredential ) {
dockerImage.push()
}
}
}
}

}
}
