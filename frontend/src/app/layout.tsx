import "./globals.css";
import localFont from "next/font/local";

const pretandard = localFont({
  src: "../assets/fonts/Pretendard-Medium.woff",
});

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en" className={pretandard.className}>
      <body className="antialiased">{children}</body>
    </html>
  );
}
