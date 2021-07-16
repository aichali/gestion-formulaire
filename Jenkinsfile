pipeline {
  agent {
    node {
      label 'docker'
    }

  }
  stages {
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