"use client";

import { useState } from "react";

export default function GetUser() {
  const [id, setId] = useState("");
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [response, setResponse] = useState("");

  const handleGet = async () => {
    try {
      console.log(name)
      const res = await fetch(`/api/user${id ? `?id=${id}` : ""}`,{
        method:'PUT',
        body:JSON.stringify({name,email})      
      });
      const data = await res.json();
      setResponse(JSON.stringify(data, null, 2));
    } catch (error) {
      setResponse("Error fetching user data.");
    }
  };

  return (
    <div>
      <h1>유저 수정</h1>
      <input
        type="text"
        placeholder="아이디 입력력"
        value={id}
        onChange={(e) =>setId(e.target.value)}
      />
      <input
        type="text"
        placeholder="이름 입력력"
        value={name}
        onChange={(e) => setName(e.target.value)}
      />
      <input
        type="text"
        placeholder="email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <button onClick={handleGet}>생성</button>
      <pre>{response}</pre>
    </div>
  );
}
