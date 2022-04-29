import React from 'react'
import { Container } from 'react-bootstrap'

const RegisterOrganizer = ({ registerOrganizer }) => {
  return (
    <Container>
      <form onSubmit={registerOrganizer}>
        <div className="mb-3">
          <label htmlFor="register-email" className="form-label">Email</label>
          <input type="email" className="form-control" id="register-email" placeholder="mail@example.com"/>
        </div>

        <div className="mb-3">
          <label htmlFor="register-firstname" className="form-label">Organization Name</label>
          <input type="text" className="form-control" id="register-orgname"/>
        </div>

        <div className="mb-3">
          <label htmlFor="register-password" className="form-label">Password</label>
          <input type="password" className="form-control" id="register-password"/>
        </div>

        <div className="mb-3">
          <label htmlFor="register-password" className="form-label">Confirm Password</label>
          <input type="password" className="form-control" id="register-confirm-pass"/>
        </div>
        
        <button type="submit" className="btn btn-primary mb-3">Register</button>
      </form>
    </Container>
  )
}

export default RegisterOrganizer