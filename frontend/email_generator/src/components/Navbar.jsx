import { Link, useNavigate } from "react-router-dom";
import logo from "../assets/AI Email Logo.png";

function Navbar() {
  const navigate = useNavigate();

  const userId =
    localStorage.getItem("userId");

  const fullName =
    localStorage.getItem("fullName");

  const logout = () => {
    localStorage.clear();

    navigate("/login");
  };

  return (
    <nav className="navbar">
      <div className="logo">
        <img
          src={logo}
          alt="AI Email Generator Logo"
          className="logo-img"
        />
        <span>AI Email Generator</span>
      </div>

      <div className="nav-links">
        <Link to="/">Home</Link>

        {userId && (
          <>
            <Link to="/history">
              History
            </Link>

            <span className="user-name">
              {fullName}
            </span>

            <button
              className="logout-btn"
              onClick={logout}
            >
              Logout
            </button>
          </>
        )}

        {!userId && (
          <>
            <Link to="/login">
              Login
            </Link>

            <Link to="/register">
              Register
            </Link>
          </>
        )}
      </div>
    </nav>
  );
}

export default Navbar;