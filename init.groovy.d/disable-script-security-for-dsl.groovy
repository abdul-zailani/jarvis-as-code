import javaposse.jobdsl.plugin.GlobalJobDslSecurityConfiguration
import jenkins.model.GlobalConfiguration

// Disable script security for Job DSL
GlobalConfiguration.all().get(GlobalJobDslSecurityConfiguration.class).useScriptSecurity = false
