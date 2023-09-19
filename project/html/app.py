from flask import Flask, render_template, request
import time

app = Flask(__name__)

array = []
animation_speed = 1  # in seconds

@app.route('/')
def index():
    return render_template('index.html', array=array)

@app.route('/add', methods=['POST'])
def add_to_array():
    num = int(request.form['num'])
    array.append(num)
    return render_template('index.html', array=array)

@app.route('/search', methods=['POST'])
def linear_search():
    target = int(request.form['target'])
    search_results = []

    for i, num in enumerate(array):
        search_results.append((num, 'yellow'))
        if num == target:
            search_results[-1] = (num, 'green')
            break
        else:
            search_results[-1] = (num, 'red')
        time.sleep(animation_speed)

    return render_template('index.html', array=array, search_results=search_results)

if __name__ == '__main__':
    app.run(debug=True)
