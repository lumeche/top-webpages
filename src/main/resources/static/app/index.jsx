import React from 'react'
import {render} from 'react-dom'
import ReactDom from 'react-dom'

class App extends React.Component{
	render(){
		return (
		  <p>I'm here!!!!!!!</p>
		)
	}
}

ReactDom.render(<App/>,document.getElementById('app'));