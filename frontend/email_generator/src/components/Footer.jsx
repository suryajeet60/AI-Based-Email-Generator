import logo from "../assets/AI Email Logo.png";

function Footer() {
  return (
    <footer className="footer">
      <div className="footer-content">

        <div className="footer-brand">

        <div className="footer-logo">
          <img src={logo} alt="AI Email Generator Logo" />
          <h3>AI Email Generator</h3>
        </div>

        <p>
          Generate professional emails instantly
          using Artificial Intelligence.
        </p>

      </div>

        <div className="footer-links">
          <h4>Quick Links</h4>

          <a href="/">Home</a>
          <a href="/history">History</a>
          <a href="/login">Login</a>
          <a href="/register">Register</a>
        </div>

        <div className="footer-tech">
          <h4>Features</h4>

          <p>Generate</p>
          <p>Save</p>
          <p>Copy</p>
          <p>Manage</p>
        </div>

        <div className="footer-ai">
          <h4>AI Capabilities</h4>

          <p>Professional Writing</p>
          <p>Grammar Enhancement</p>
          <p>Personalized Content</p>
          <p>Instant Generation</p>
        </div>

      </div>

      <div className="footer-bottom">
        © 2025 AI Email Generator | Developed by Suryajeet Pandhare
      </div>
    </footer>
  );
}

export default Footer;