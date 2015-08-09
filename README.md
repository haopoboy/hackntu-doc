## Life for Food

Recommends food price and show trend.

## Profiles

Using application.properties and application.yml to separate configuration.

1. default: default is development, embedded Tomcat and H2 will start
2. test: now same as default
3. production: only embedded Tomcat will start

## Routing

Routing configuration is in JS block of <b>index.html</b>

1. /#/recommend - show recommends
2. /#/info/:id - id for food details
3. /#/search/:text - for search, you know
