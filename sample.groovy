def slackMsg(){

    echo pwd()
	    sh ("ls -la")
	    sh("ls -la ../")
    slackSend color: '#00FF00', message: getBuildStatus()

	
def getBuildStatus() {
    def stat = currentBuild.currentResult
    if (currentBuild?.getPreviousBuild()?.resultIsWorseOrEqualTo('FAILURE') && currentBuild.currentResult == "SUCCESS") {stat = 'BUILD_FIXED'}
    if (currentBuild?.getPreviousBuild()?.resultIsWorseOrEqualTo('FAILURE') && currentBuild.currentResult == "FAILURE") {stat = 'STILL_FAILING'}
    if (currentBuild?.getPreviousBuild()?.result == 'UNSTABLE' && currentBuild.currentResult == "SUCCESS") {stat = 'BUILD_STABLE'}
    return stat
}
	
}
return this
