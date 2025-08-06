import logo from './logo.svg';
import './App.css'; // Importing the CSS file for styling

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Welcome to the First Session of React App</h1>
        
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>

        <p>
          This is a simple React application to demonstrate the basic structure and functionality.
        </p>
        
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>

      
      <img src={logo} className="App-logo" alt="logo" />
      <h2>My React Application</h2>
      <p>This is a simple example of a React app.</p>
      <p>Feel free to modify the code and see the changes live!</p>
      <p>Enjoy coding!</p>
      

    </div>

  );
}

export default App;
