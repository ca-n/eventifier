import { useState } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Create from "./components/create/Create";
import Dashboard from "./components/dashboard/Dashboard";
import Login from "./components/login/Login";
import Logout from "./components/logout/Logout";
import EventifierNavbar from "./components/navbar/EventifierNavbar";
import Register from "./components/register/Register";


function App() {
  const [user, setUser] = useState({
    email: "",
    userType: "",
  })
  const [isLoggedIn, setIsLoggedIn] = useState(false)

  return (
    <div className="App">
      <Router>
        <EventifierNavbar user={user} isLoggedIn={isLoggedIn}/>
        <Routes>
          <Route path="/login" element={<Login setUser={setUser} setIsLoggedIn={setIsLoggedIn}/>}/>
          <Route path="/register" element={<Register/>}/>
          <Route path="/" element={<Dashboard user={user}/>}/>
          <Route path="/dashboard" element={<Dashboard user={user}/>}/>
          <Route path="/create" element={<Create user={user}/>}/>
          <Route path="/logout" element={<Logout setUser={setUser} setIsLoggedIn={setIsLoggedIn}/>}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
