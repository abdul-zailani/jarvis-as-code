# Jenkins as Code (JCasC)

Automated Jenkins configuration management using Configuration as Code approach.

## 🎯 Benefits

- ✅ **Versioned & Auditable**: All configurations tracked in Git
- ✅ **Reproducible**: Consistent Jenkins setup across all environments
- ✅ **Automated**: Zero-touch deployment and job generation
- ✅ **Secure**: Secrets via environment variables, role-based access control
- ✅ **Developer-Friendly**: Self-service pipeline creation and easy testing

## 📁 Project Structure

```
jenkins-as-code/
├── .github/workflows/
│   ├── deploy-jcasc.yml          # Auto-deploy config to Jenkins server
│   └── validate-jcasc.yml        # Validate config on Pull Requests
│
├── docker/
│   ├── .env                      # Environment variables (gitignored)
│   ├── docker-compose.yml        # Local Jenkins deployment
│   ├── Dockerfile                # Jenkins master image
│   └── plugins.txt               # Required Jenkins plugins
│
├── jcasc/
│   └── jenkins.yaml              # Main configuration (system, security, credentials, jobs)
│
├── dsl/
│   └── generate-pipelines.groovy # Auto-generate jobs from cicd repo
│
├── init.groovy.d/
│   └── disable-script-security-for-dsl.groovy  # Init scripts for Jenkins startup
│
└── README.md
```

## 🚀 Quick Start

```bash
# 1. Setup environment
cp docker/.env.example docker/.env
vim docker/.env  # Configure GITHUB_USERNAME and GITHUB_TOKEN

# 2. Start Jenkins
cd docker
docker compose up --build

# 3. Access Jenkins
open http://localhost:8080
# Login: admin / admin (or from .env)

# 4. Trigger seed-job to generate pipeline jobs
# Jenkins UI → seed-job → Build Now
```
