node('linux') {
    stage('Unit Tests') {
        sh "ant -f test.xml -v"
    }
    stage('Build') {
        sh "ant -f build.xml -v"
    }
     stage('Deploy') {
         sh "aws s3 cp ${WORKSPACE}/dist/rectangle-${BUILD_NUMBER}.jar s3://ainajenkins/rectangle-${BUILD_NUMBER}.jar"
    }
     stage('Report') {
        sh "aws cloudformation describe-stack-resources --region us-east-1 --stack-name jenkins"         
    }
}
