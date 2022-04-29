import { useState } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Login from "./components/login/Login";
import EventifierNavbar from "./components/navbar/EventifierNavbar";
import Register from "./components/register/Register";


function App() {
  const [user, setUser] = useState({})

  return (
    <div className="App">
      <Router>
        <EventifierNavbar/>
        <Routes>
          <Route path="/login" element={<Login setUser={setUser}/>}/>
          <Route path="/register" element={<Register/>}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
