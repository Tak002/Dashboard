"use client";

import { useState } from "react";

type Role = "ROLE_USER" | "ROLE_ADMIN";

export default function GetUser() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [role, setRole] = useState<Role | null>("ROLE_USER");
  const [response, setResponse] = useState("");

  const handleGet = async () => {
    try {
      console.log(password)
      const res = await fetch(`/api/user`,{
        method:'POST',
        body:JSON.stringify({email,password,role})      
      });
      const data = await res.json();
      setResponse(JSON.stringify(data, null, 2));
    } catch (error) {
      setResponse("Error fetching user data.");
    }
  };

  function handleRole(checkedRole: Role){
    setRole(checkedRole)
    console.log(checkedRole)
  }

  return (
    <div>
      <h1>유저 생성</h1>
      <input
        type="text"
        placeholder="Enter Email"
        value={email}
        onChange={(e) => {
          setEmail(e.target.value)
        }}
      />
      
      <input
        type="text"
        placeholder="Enter Password"
        value={password}
        onChange={(e) => {
          setPassword(e.target.value)
        }}
      />
      
      <h6>ROLE_USER</h6>

      <input
        type= "checkbox"
        checked={role==="ROLE_USER"}
        onChange={() => {
          handleRole("ROLE_USER")
        }}
      />

     <h6>ROLE_ADMIN</h6>

      <input
        type= "checkbox"
        checked={role==="ROLE_ADMIN"}
        onChange={() => {
          handleRole("ROLE_ADMIN")
        }}
      />
      
      <button onClick={handleGet}>생성</button>
      <pre>{response}</pre>
    </div>
  );
}
