import { useEffect, useState } from "react";

function GeneratedEmail({ generatedEmail }) {
  const [displayedText, setDisplayedText] =
    useState("");

  useEffect(() => {
    if (!generatedEmail) return;

    setDisplayedText("");

    let index = 0;

    const interval = setInterval(() => {
      setDisplayedText(
        generatedEmail.slice(0, index + 1)
      );

      index++;

      if (
        index >= generatedEmail.length
      ) {
        clearInterval(interval);
      }
    }, 15); // typing speed

    return () =>
      clearInterval(interval);
  }, [generatedEmail]);

  const copyEmail = () => {
    navigator.clipboard.writeText(
      generatedEmail
    );

    alert(
      "Email copied successfully"
    );
  };

  if (!generatedEmail) return null;

  return (
    <div className="result-box">
      <h3>Generated Email</h3>

      <pre className="typing-text">
        {displayedText}
        <span className="cursor">
          |
        </span>
      </pre>

      <button onClick={copyEmail}>
        Copy Email
      </button>
    </div>
  );
}

export default GeneratedEmail;