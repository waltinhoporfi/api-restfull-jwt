# api-restfull-jwt
<h3>Api RestFul Json Web Token</h3>

User Registration Registers a new user and returns its access token.

<strong>URL: "/signup"</strong><br>
<strong>Method: "POST"</strong><br>
<strong>Data Params:</strong><br>

<pre><code>
{
  "firstName": "Walter",
  "lastName": "Porfirio",
  "email": "walter@email.com",
	"password": "123456",
  "phones": [
    {
      "number": 996919934,
      "area_code": 81,
      "country_code": "+55"
    }
  ]
}
</code></pre>

Success Response: Code:

200 OK Content:

<pre>
<code>
{ "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3YWx0ZXJAZW1haWwuY29tIiwidXNlciI6IntcImZpcnN0TmFtZVwiOlwiV2FsdGVyXCIsXCJsYXN0TmFtZVwiOlwiUG9yZmlyaW9cIixcImVtYWlsXCI6XCJ3YWx0ZXJAZW1haWwuY29tXCIsXCJwaG9uZXNcIjpbe1wibnVtYmVyXCI6OTk2OTE5OTM0LFwiYXJlYV9jb2RlXCI6ODEsXCJjb3VudHJ5X2NvZGVcIjpcIis1NVwifV0sXCJjcmVhdGVkX2F0XCI6MTYwOTg4ODM3NDYyNSxcImxhc3RfbG9naW5cIjoxNjA5ODg4NTQ4MTMzfSIsImlhdCI6MTYwOTg4ODU0OCwiZXhwIjoxNjA5ODg4NjA4fQ.2ldy_tClnybHSbF3xIPEKwurhP_oc3nEoQft87sG744" }
<code>
</pre>


Error Response:

Code: 400 BAD REQUEST Content: 

<pre><code>
{ "message": "Email already exists" "code": "400" }
</code></pre>

OR

Code: 400 BAD REQUEST Content: 

<pre><code>
{ "message": "Invalid fields" "code": "400" } 
</code></pre>

OR

Code: 400 BAD REQUEST Content: 

<pre><code>
{ "message": "Missing fields" "code": "400" }
</code></pre>

<h3>User Authentication Validates user credentials and returns its access token.</h3>

URL /signin

Method: POST

Data Params: 

<pre><code>
{ "email": "walter@email.com", "password": "123456" }
</code></pre>

Success Response: Code: 200 OK Content: 

<pre><code>
{ "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3YWx0ZXJAZW1haWwuY29tIiwidXNlciI6IntcImZpcnN0TmFtZVwiOlwiV2FsdGVyXCIsXCJsYXN0TmFtZVwiOlwiUG9yZmlyaW9cIixcImVtYWlsXCI6XCJ3YWx0ZXJAZW1haWwuY29tXCIsXCJwaG9uZXNcIjpbe1wibnVtYmVyXCI6OTk2OTE5OTM0LFwiYXJlYV9jb2RlXCI6ODEsXCJjb3VudHJ5X2NvZGVcIjpcIis1NVwifV0sXCJjcmVhdGVkX2F0XCI6MTYwOTg4ODM3NDYyNSxcImxhc3RfbG9naW5cIjoxNjA5ODg4NTQ4MTMzfSIsImlhdCI6MTYwOTg4ODU0OCwiZXhwIjoxNjA5ODg4NjA4fQ.2ldy_tClnybHSbF3xIPEKwurhP_oc3nEoQft87sG744" }
</code></pre>

Error Response: Code: 400 BAD REQUEST Content: 

<pre><code>
{ "message": "Invalid email or password" "code": "400" } OR
</code></pre>

Code: 400 BAD REQUEST Content: 

<pre><code>
{ "message": "Missing fields" "code": "400" }
</code></pre>

User Details Returns user details.

URL /me

Method: GET

Success Response: Code: 200 OK Content: 

<pre><code>
{
  "firstName": "Walter",
  "lastName": "Porfirio",
  "email": "walter@email.com",
	"password": "123456",
  "phones": [
    {
      "number": 996919934,
      "area_code": 81,
      "country_code": "+55"
    }
  ],
"created_at": "2019-05-17T04:12:27.081+0000",
"last_login": "2019-05-17T04:12:27.107+0000"
}
</code></pre>

Error Response: Code: 401 UNAUTHORIZED Content: { "message": "Unauthorized" "code": "401" } OR

Code: 401 UNAUTHORIZED Content: { "message": "Unauthorized - invalid session" "code": "401" }


<h2>Url Cloud (Heroku):</h2>

<link>https://api-restfull-jwt.herokuapp.com/</link>





























