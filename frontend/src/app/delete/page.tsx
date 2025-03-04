"use client";

import { useState } from "react";

export default function GetUser() {
  const [id, setId] = useState("");
  const [response, setResponse] = useState("");

  const handleGet = async () => {
    try {
      const res = await fetch(`/api/user${id ? `?id=${id}` : ""}`,{
        method:'DELETE'
      });
      const data = await res.json();
      setResponse(JSON.stringify(data, null, 2));
    } catch (error) {
      setResponse("Error fetching user data.");
    }
  };

  return (
    <div>
      <h1>유저 삭제</h1>
      <input
        type="text"
        placeholder="ID 입력"
        value={id}
        onChange={(e) => setId(e.target.value)}
      />
      <button onClick={handleGet}>삭제</button>
      <pre>{response}</pre>
    </div>
  );
}
