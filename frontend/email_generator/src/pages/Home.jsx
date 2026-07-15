import { useState } from "react";
import PromptBox from "../components/PromptBox";
import GeneratedEmail from "../components/GeneratedEmail";
import API from "../services/api";

function Home() {
  const [prompt, setPrompt] = useState("");
  const [generatedEmail, setGeneratedEmail] = useState("");
  const [loading, setLoading] = useState(false);

  const generateEmail = async () => {
    if (!prompt.trim()) {
      alert("Please enter a prompt");
      return;
    }

    try {
      setLoading(true);

      const userId = localStorage.getItem("userId");

      const response = await API.post(
        `/email/generate/${userId}`,
        {
          prompt,
        }
      );

      setGeneratedEmail(
        response.data.generatedEmail
      );
    } catch (error) {
      console.error(error);
      alert("Failed to generate email");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="container">
      <h1>AI Email Generator</h1>

      <PromptBox
        prompt={prompt}
        setPrompt={setPrompt}
        onGenerate={generateEmail}
        loading={loading}
      />

      <GeneratedEmail
        generatedEmail={generatedEmail}
      />
    </div>
  );
}

export default Home;