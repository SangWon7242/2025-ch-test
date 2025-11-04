"use client";

import Link from "next/link";
import { useState, useEffect } from "react";

interface ChatRoom {
  id: number;
  createdDate: Date;
  updateDate: Date;
  name: string;
}

export default function App() {
  const [chatRooms, setChatRooms] = useState<ChatRoom[]>([]);

  useEffect(() => {
    async function fetchChatRooms() {
      const response = await fetch("http://localhost:8080/api/v1/chat/rooms");
      const data = await response.json();
      setChatRooms(data);
    }

    fetchChatRooms();
  }, []);

  return (
    <nav>
      <ul>
        {chatRooms.map((chatRoom) => (
          <li key={chatRoom.id}>
            {/* 기본 방식: URL만 전달 */}
            <Link href={`/chat/rooms/${chatRoom.id}`}>{chatRoom.name}</Link>

            {/* 방법 1: Query Parameter로 추가 데이터 전달 */}
            {/* <Link href={{
              pathname: `/chat/rooms/${chatRoom.id}`,
              query: { name: chatRoom.name, created: chatRoom.createdDate }
            }}>{chatRoom.name}</Link> */}

            {/* 방법 2: 배열 데이터를 JSON 문자열로 전달 */}
            {/* <Link href={{
              pathname: `/chat/rooms/${chatRoom.id}`,
              query: { roomData: JSON.stringify(chatRoom) }
            }}>{chatRoom.name}</Link> */}
          </li>
        ))}
      </ul>
    </nav>
  );
}
