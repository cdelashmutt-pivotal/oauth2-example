# OAuth2 Example with Cloud Foundry

## Client Credentials Flow

### Install the uaac CLI

    $ gem install cf-uaac
    
### Register a new client with UAA

    $ uaac target uaa.<your.cf.domain> [--skip-ssl-validation]
    $ uaac token client get admin -s <password from the Admin Client Credentials line in Ops Manager -> Elastic runtime -> Credentials>
    $ uaac client add fooapp --secret barpass --authorized_grant_types "client_credentials,refresh_token" --authorities "clients.read"
    
### Test it out
Run the ClientCredentialsTest.testClientCredentials test method to test out calling the ["List Clients" API] (https://github.com/cloudfoundry/uaa/blob/master/docs/UAA-APIs.rst#list-clients-get-oauthclients)