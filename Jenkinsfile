//DECLARATIVE
pipeline {
    agent any
    //agent { myDockerHub { image 'maven:3.6.3'}}
    environment{
       dockerHome = tool 'myDocker'
       mavenHome = tool 'myMaven'
       PATH = "$dockerHome/bin:$mavenHome/bin:$PATH"
       registry = "arundhwaj/hello-world-jenkins"
       registryCredential = 'dockerhub'  
    }
    stages {
        stage('Checkout') {
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
    }   
        stages {
            stage('Cloning our Git') {
                steps {
                    git 'https://github.com/ArunDhwaj/hello-world-jenkins'
                }
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
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }    
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                    dockerImage.push()
                   }        
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
