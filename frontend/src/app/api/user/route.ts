import { NextRequest, NextResponse } from "next/server";

const BASE_URL = "http://localhost:8080/users"; // Spring 백엔드 주소

export async function GET(req: NextRequest) {
  const { searchParams } = new URL(req.url);
  const id = searchParams.get("id");

  try {
    const res = await fetch(id ? `${BASE_URL}/${id}` : BASE_URL);
    const data = await res.json();
    return NextResponse.json(data);
  } catch (error) {
    return NextResponse.json({ message: "Failed to fetch user(s)" }, { status: 500 });
  }
}

export async function DELETE(req: NextRequest) {
    const { searchParams } = new URL(req.url);
    const id = searchParams.get("id");
    if (id==null){
        console.log('Empty id')
        return NextResponse.json({ message: "Enter the ID you want to delete" }, { status: 500 });
    }
    try {
      const res = await fetch(`${BASE_URL}/${id}`,{
        method:'DELETE'
      });
      const data = await res.json();
      return NextResponse.json(data);
    } catch (error) {
      return NextResponse.json({ message: "Failed to fetch user(s)" }, { status: 500 });
    }
  }

  export async function POST(req: NextRequest) {
    const body = await req.json()
    const {name, email} = body;
    try {
      const res = await fetch(`${BASE_URL}`,{
        method: 'POST',
        headers: {
          "Content-Type": "application/json",  // 🔹 Content-Type 추가
        },
        body:JSON.stringify({name,email})
      });
      const data = await res.json();
      return NextResponse.json(data);
    } catch (error) {
      return NextResponse.json({ message: "Failed to fetch user(s)" }, { status: 500 });
    }
  }

  export async function PUT(req: NextRequest) {
    const { searchParams } = new URL(req.url);
    const id = searchParams.get("id");
    const body = await req.json()
    const {name, email} = body;
    try {
      const res = await fetch(`${BASE_URL}/${id}`,{
        method: 'PUT',
        headers: {
          "Content-Type": "application/json",  // 🔹 Content-Type 추가
        },
        body:JSON.stringify({id, name,email})
      });
      const data = await res.json();
      return NextResponse.json(data);
    } catch (error) {
      return NextResponse.json({ message: "Failed to fetch user(s)" }, { status: 500 });
    }
  }