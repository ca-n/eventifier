import { useState } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Dashboard from "./components/dashboard/Dashboard";
import Login from "./components/login/Login";
import EventifierNavbar from "./components/navbar/EventifierNavbar";
import Register from "./components/register/Register";


function App() {
  const [user, setUser] = useState({
    email: ""
  })

  return (
    <div className="App">
      <Router>
        <EventifierNavbar user={user}/>
        <Routes>
          <Route path="/login" element={<Login setUser={setUser}/>}/>
          <Route path="/register" element={<Register/>}/>
          <Route path="/dashboard" element={<Dashboard/>}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
