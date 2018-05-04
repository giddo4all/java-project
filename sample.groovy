
def slackMsg(){

    //echo pwd()
	    //sh ("ls -la")
	   // sh("ls -la ../")
	def ny = 'gideon.aina@test.com'
	slackSend color: '#00FF00', message: getBuildStatus() +"\n " + getUserMentionID(ny)
}
return this

def getBuildStatus() {
    def stat = currentBuild.currentResult
    if (currentBuild?.getPreviousBuild()?.resultIsWorseOrEqualTo('FAILURE') && currentBuild.currentResult == "SUCCESS") {stat = 'BUILD_FIXED'}
    if (currentBuild?.getPreviousBuild()?.resultIsWorseOrEqualTo('FAILURE') && currentBuild.currentResult == "FAILURE") {stat = 'STILL_FAILING'}
    if (currentBuild?.getPreviousBuild()?.result == 'UNSTABLE' && currentBuild.currentResult == "SUCCESS") {stat = 'BUILD_STABLE'}
    return stat
}

def getUserMentionID(key){
	//def slk = load 'mention.slack'
	def slk = readFile 'mention.slack'
	echo slk
	def userMentionMap = slk.inject([:])
//	def userMentionMap = [
	//('gideon.aina@test.com'): '<@U85FWQDFW>'
//		slk
//]
return userMentionMap.get(key)
}

