//DECLARATIVE
pipeline {
    agent any
    //agent { myDockerHub { image 'maven:3.6.3'}}
    environment{
       dockerHome = tool 'myDocker'
       mavenHome = tool 'myMaven'
        registry = "arundhwaj/hello-world-jenkins"
    registryCredential = 'mydockerhub' 
       PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn --version'
                sh 'docker version'
                echo "Build"
                echo "PATH - $PATH"
                echo "Build_NUMBER - $env.BUILD_NUMBER"
                echo "Build_ID - $env.BUILD_ID"
                echo "JOB_NAME - $env.JOB_NAME"
                echo "BUILD_TAG - $env.BUILD_TAG"
                echo "BUILD_URL - $env.BUILD_URL"
            }
        }        
        stage('Test') {
            steps {
                echo "Test"
            }
        }
        stage('Integration Test') {
            steps {
                echo "Integration Test"
            }
        }
        stage('Build Docker Image') {
            steps {
                //docker build -t arundhwaj/FootballMatch:Prod-v1
                script {
                    dockerImage = docker.build("arundhwaj/hello-world-jenkins:${env.BUILD_TAG}")
                }
            }
        }
       
        stage('Push image') {
         withCredentials([usernamePassword( credentialsId: 'mydockerhub', usernameVariable: 'arundhwaj', passwordVariable: 'arundhwaj123')]) {
        def registry_url = "registry.hub.docker.com/"
        bat "docker login -u $USER -p $PASSWORD ${registry_url}"
        docker.withRegistry("http://${registry_url}", "mydockerhub") {
            // Push your image now
            bat "docker push arundhwaj/hello-world-jenkins:build"
        }
    }
}
    }

    post {
        always {
            echo 'I run always'
        }
        success {
            echo 'I run when i m suceessful'
        }
        failure {
            echo 'I run when i m failure'
        }
    }
}
