# New Relic Agent Troubleshooting

This repo is update on a classic internal project created to provide a set of problems to help people get more familiar
with how different parts of the java agent work.

## Setup
There's a java agent in this project you can use, or you can use your own.  
If you use your own, you will need to modify the `applicationDefaultJvmArgs` 
in the `build.gradle` file provided.

The easiest approach is copying the `newrelic-example.yml` to `newrelic.yml` in the same directory
and use the `newrelic-agent.jar` file provided as they are already setup to work with the Gradle
`application` plugin.

Then from root of project, run `./gradlew run`.

It is likely the agent won't load because there is no license key specified either
* In the new `newrelic.yml` file OR
* as a system property OR
* as an environment variable

First exercise is to specify your license key in one of these ways.

Once you have, `./gradlew run` should start out with no errors and some output that looks like this:

```
2022-06-23T16:18:05,332-0400 [6255 1] com.newrelic INFO: New Relic Agent: Loading configuration file "/Users/yourid/projects/newrelic-agent-troubleshooting/app/newrelic/newrelic.yml"
2022-06-23T16:18:05,381-0400 [6255 1] com.newrelic INFO: Using configured collector host: staging-collector.newrelic.com
2022-06-23T16:18:05,381-0400 [6255 1] com.newrelic INFO: Using default metric ingest URI: https://metric-api.newrelic.com/metric/v1
2022-06-23T16:18:05,381-0400 [6255 1] com.newrelic INFO: Using default event ingest URI: https://insights-collector.newrelic.com/v1/accounts/events
2022-06-23T16:18:05,429-0400 [6255 1] com.newrelic INFO: New Relic Agent: Writing to log file: /Users/yourid/projects/newrelic-agent-troubleshooting/app/newrelic/logs/newrelic_agent.log
Listening for transport dt_socket at address: 5005
a transaction has been created!
a transaction has been created!
a transaction has been created!
```