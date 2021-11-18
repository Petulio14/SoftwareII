import React, { Component } from 'react'
import { Form, Button } from 'react-bootstrap'

export default class Formulario extends Component {
    render() {
        return (
            <div style={{ display: 'flex', alignItems: 'center', flexDirection: 'column', marginTop: 100 }}>
                <Form>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Label>Correo electronico</Form.Label>
                    <Form.Control type="email" placeholder="Ingrese su correo" />
                    <Form.Text className="text-muted">
                    Este correo sera publico asi que pilas.
                    </Form.Text>
                </Form.Group>

                <Form.Group className="mb-3" controlId="formBasicPassword">
                    <Form.Label>Contraseña</Form.Label>
                    <Form.Control type="password" placeholder="la super clave" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formBasicCheckbox">
                    <Form.Check type="checkbox" label="Recuerdame" />
                </Form.Group>
                <Button variant="primary" type="submit">
                    Ingresar
                </Button>
                </Form>
            </div>
        )
    }
}
