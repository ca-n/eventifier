import React, { useEffect } from 'react'
import { useNavigate } from 'react-router-dom'

const Logout = ({ setUser, setIsLoggedIn }) => {
    const navigate = useNavigate()
    useEffect(() => {
        setUser({
            email: "",
            userType: ""
        })
        setIsLoggedIn(false)
        navigate("/login")
    })

  return (
      <></>
  )
}

export default Logout