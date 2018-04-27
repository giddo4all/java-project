properties([pipelineTriggers([githubPush()])])
node('linux') {
    git url: 'https://github.com/jasondbaker/infrastructure-pipeline.git', branch: 'master'
    stage('Unit Tests') {
        sh "ant -f test.xml -v"
    }
    stage('Build') {
        sh "ant -f build.xml -v"
    }
     stage('Deploy') {
         withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: '8b04e9ea-b46b-4877-9542-9f32a877929a', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
         sh "aws s3 cp ${WORKSPACE}/dist/rectangle-${BUILD_NUMBER}.jar s3://ainajekins/rectangle-${BUILD_NUMBER}.jar"
         }
    }
     stage('Report') {
         withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: '8b04e9ea-b46b-4877-9542-9f32a877929a', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
        sh "aws cloudformation describe-stack-resources --region us-east-1 --stack-name jenkins"    
         }
    }
}
