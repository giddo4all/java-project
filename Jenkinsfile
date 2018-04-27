//properties([pipelineTriggers([githubPush()])])
node('linux') {
    git url: 'https://github.com/giddo4all/java-project.git', branch: 'master'
    stage('Unit Tests') {
        sh "ant -f test.xml -v"
    }
    stage('Build') {
        sh "ant -f build.xml -v"
    }
     stage('Deploy') {
         sh "ls -la ${WORKSPACE}/dist"
         sh "aws s3 cp ${WORKSPACE}/dist/rectangle-${BUILD_NUMBER}.jar s3://ainajenkins/rectangle-${BUILD_NUMBER}.jar"
    }
        stage('Report') {
        sh "aws cloudformation describe-stack-resources --region us-east-1 --stack-name jenkins"
        sh "env | sort"
        sh "ls -la"   
        sh "ls -la ${WORKSPACE}/reports"
        sh "ls -la ${WORKSPACE}/bin"
            
    }
}
