<h1 align="center">character-counting ✏️ ️🧮</h1>
<h3 align="center">скрипт для подсчета символов в строке</h3>
<hr>

<h2>🟥 функционал: </h2>
<h3>способы передачи строки в приложение: </h3>

<ul>
    <details>
      <summary>через строку запроса️</summary>
            <code>http://localhost:8080/counter/{text}</code>
        <ul>
            <li style="list-style-position: inside;">вместо "text" подставляется нужная фраза: </li>
            <code>http://localhost:8080/counter/J aaAa abcc,,*cc</code>
            <li style="list-style-position: inside;">результат: </li>
            <img src="src/main/resources/templates/результат запроса с переменной пути.png" alt="результат запроса с переменной пути" align="center">
        </ul>
    </details>
    <details>
      <summary>через строку запроса, передав JSON</summary>
            <code>http://localhost:8080/counter</code>
        <ul>
            <li style="list-style-position: inside;">в теле запроса передается JSON: </li>
            <code>{"text": "J aaAa abcc,,*cc"}</code>
            <li style="list-style-position: inside;">результат: </li>
            <img src="src/main/resources/templates/результат запроса с JSON'ом.png" alt="результат запроса с 
JSON'ом" align="center">
        </ul>
    </details>
</ul>
<hr>