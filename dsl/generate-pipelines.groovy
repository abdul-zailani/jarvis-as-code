// Generate pipeline jobs from all .groovy files in jenkinsfile/pipeline/
def repoUrl = System.getenv('CICD_REPO_URL') ?: 'https://github.com/Lionparcel/cicd.git'
def repoBranch = System.getenv('CICD_REPO_BRANCH') ?: 'master'
def credentialsId = System.getenv('CICD_REPO_CREDENTIALS') ?: 'github-token'
def pipelineDir = System.getenv('CICD_PIPELINE_DIR') ?: 'jenkinsfile/pipeline'

// Scan workspace for groovy files (seed job already cloned the repo)
def workspace = new File('/var/jenkins_home/workspace/seed-job')
def pipelineDirectory = new File(workspace, pipelineDir)

if (pipelineDirectory.exists() && pipelineDirectory.isDirectory()) {
    pipelineDirectory.listFiles().each { file ->
        if (file.name.endsWith('.groovy') && file.isFile()) {
            def jobName = file.name.replace('.groovy', '')

            pipelineJob(jobName) {
                definition {
                    cpsScm {
                        scm {
                            git {
                                remote {
                                    url(repoUrl)
                                    credentials(credentialsId)
                                }
                                branch(repoBranch)
                            }
                        }
                        scriptPath("${pipelineDir}/${file.name}")
                    }
                }
            }
        }
    }
}
