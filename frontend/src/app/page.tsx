import Link from "next/link";

export default function Home() {
  return (
    <div>
      <h1>유저 관리 시스템</h1>
      <nav>
        <ul>
          <li><Link href="/get">유저 조회</Link></li>
          <li><Link href="/post">유저 생성</Link></li>
          <li><Link href="/update">유저 수정</Link></li>
          <li><Link href="/delete">유저 삭제</Link></li>
        </ul>
      </nav>
    </div>
  );
}
