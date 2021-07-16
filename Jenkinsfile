pipeline {
agent any
 	stages {
     stage('Docker node test') {
      agent {
        docker {
          image 'node:7-alpine'
          args '--name docker-node' // list any args
        }
      }
      steps {
        // Steps run in node:7-alpine docker container on docker slave
        sh 'node --version'
      }
    }

   
   
    		stage('Build') {
      			steps {
        				echo 'Build Step'
      			}
    		}
stage('Tests') {
      			steps {
        				echo 'Tests Stage'
      			}
    		}
stage('Analyses') {
      			steps {
        				echo 'Code Analysis Stage'
     			}
    		}
stage('Deploy') {
      			steps {
        				echo 'Deploy Stage'
      			}
    		}
         }
}
