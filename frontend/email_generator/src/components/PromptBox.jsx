function PromptBox({
  prompt,
  setPrompt,
  onGenerate,
  loading
}) {
  return (
    <>
      <textarea
        rows="8"
        placeholder="Enter your email prompt..."
        value={prompt}
        onChange={(e) => setPrompt(e.target.value)}
      />

      <button
        onClick={onGenerate}
        disabled={loading}
      >
        {loading ? "Generating..." : "Generate Email"}
      </button>
    </>
  );
}

export default PromptBox;