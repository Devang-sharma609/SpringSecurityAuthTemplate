<p align="center"><h1 align="center">SpringSecurityAuthTemplate</h1></p>

<p align="center">
	<!-- Shields.io badges disabled, using skill icons. --></p>
<p align="center">Built with the tools and technologies:</p>
<p align="center">
	<a href="https://skillicons.dev">
		<img src="https://skillicons.dev/icons?i=java,spring,supabase,&theme=dark">
	</a></p>
<br>

##  How does it work?

<p>User logs in via GET request or a default Spring provided login form and gets a csrf token in response. He then sends his CSRF token anytime he wants to make a state-changing request i.e PUT, POST, DELETE.
Worst case scenario? attacker gets ur CSRF and tries to make a request but he cudn't coz Spring checks for the JSESSIONID in the sent cookie if it matches the one token was generated for. So even if the attacker also grabs ur JSESSIONID, he wud not b able to send it as a requet header coz the cookie that is automatically sent along with the request will fail the auth coz it will have a different JSESSIONID.</p>


##  Features
<ol>
<li>Basic Auth via Login Form</li>
<li>CSRF Safety</li>
<li>Session Hijack Safety</li>
</ol>


##  Getting Started

###  Prerequisites

Before getting started with SpringSecurityAuthTemplate, ensure your runtime environment meets the following requirements:

- **Programming Language:** Java


###  Installation

Install SpringSecurityAuthTemplate using one of the following methods:

**Build from source:**

1. Clone the SpringSecurityAuthTemplate repository:
```sh
❯ git clone https://github.com/Devang-sharma609/SpringSecurityAuthTemplate
```

2. Navigate to the project directory:
```sh
❯ cd SpringSecurityAuthTemplate
```

###  Usage
Run Application File with the @SpringBootApplication annotation
Use Postman for API Requests
