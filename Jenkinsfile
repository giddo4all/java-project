properties([pipelineTriggers([githubPush()])])


node('linux') {
    try {
	git 'https://github.com/giddo4all/java-project.git'
    stage('Unit Tests') {
        sh "ant -f test.xml -v"
    }
    stage('Build') {
        sh "ant -f build.xml -v"
    }
     stage('Deploy') {
          sh "aws s3 cp ${WORKSPACE}/dist/rectangle-${BUILD_NUMBER}.jar s3://ainajekins/rectangle-${BUILD_NUMBER}.jar"
    }
   } catch (Exception e) {
  currentBuild.result = 'FAILURE'   
} finally {
    echo pwd()
	    sh ("ls -la")
	    sh("ls -la ../)
    slackSend('#00FFFF' : colorCode, baseUrl : 'https://seis-602-pos-project.slack.com/services/hooks/jenkins-ci/', tokenCredentialId: 'kiwbZmTVIMmWlQUBmay6Ainb', channel: '#symtest', message: "Sent slack message")
}
           
}
