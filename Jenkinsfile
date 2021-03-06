//DECLARATIVE
pipeline {
    agent any
    //agent { myDockerHub { image 'maven:3.6.3'}}
    environment{
       dockerHome = tool 'myDocker'
       mavenHome = tool 'myMaven'
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
        stage('Push Docker Image') {
            steps {
                script {
                        docker.withRegistry('https://registry.hub.docker.com', 'mydockerhub') {
                        dockerImage.push()
                        dockerImage.push('latest')
                    }
                }
            }
        }   
        stage('SonarQube analysis')
         {
            withSonarQubeEnv(credentialsId: 'fefc64642aa30c2d0d4229a72b999c776aec1777', installationName: 'My SonarQube Server')
            {
            // You can override the credential to be used
              sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
            }
          }
        
        
   
       
     stage('Build and Test') {
        steps {
            echo 'build here...'
            echo 'run tests here if you like ...'
        }
     }
 
    }

    post {
         always {
           echo 'JUnit'
        }
        failure {
            echo 'I run when i m failure'
        }
    }
}
