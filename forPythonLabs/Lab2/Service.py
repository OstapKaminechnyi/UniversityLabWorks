from flask import Flask, jsonify, abort, make_response, request
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql+mysqlconnector://root:5555@localhost:3306/iot-test-db'
db = SQLAlchemy(app)


class Worker(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    first_name = db.Column(db.String(45))
    occupation_name = db.Column(db.String(45))
    salary_per_hour = db.Column(db.Integer)
    middle_name = db.Column(db.String(45))


@app.route('/workers', methods=['GET'])
def get_all_workers():
    workers_list = []
    all_workers = Worker.query.all()
    for workers in all_workers:
        worker = {
            'first_name': workers.first_name,
            'occupation_name': workers.occupation_name,
            'salary_per_hour': workers.salary_per_hour,
            'middle_name': workers.middle_name
        }
        workers_list.append(worker)
    db.session.commit()
    return jsonify({'workers': workers_list})


@app.route('/workers/<int:worker_id>', methods=['GET'])
def get_worker(worker_id):
    workers = Worker.query.filter_by(id=worker_id).first()
    worker = {}
    if workers is None:
        abort(400)
    else:
        worker = {
            'first_name': workers.first_name,
            'occupation_name': workers.occupation_name,
            'salary_per_hour': workers.salary_per_hour,
            'middle_name': workers.middle_name
        }
    db.session.commit()
    return jsonify({'worker': worker})


@app.errorhandler(404)
def not_found(error):
    return make_response(jsonify({'error': 'Not found'}), 404)


@app.route('/workers', methods=['POST'])
def add_worker():
    # if not request.json or not 'first name' in request.json:
    #     abort(400)
    new_worker = Worker()
    # new_worker.id = request.json['id']
    new_worker.first_name = request.json['first_name']
    new_worker.occupation_name = request.json.get('occupation_name', "")
    new_worker.salary_per_hour = request.json.get('salary_per_hour', 0)
    new_worker.middle_name = request.json.get('middle_name', "")

    db.session.add(new_worker)
    db.session.commit()
    return jsonify('Successful')


@app.route('/workers/<int:worker_id>', methods=['PUT'])
def update_worker(worker_id):
    worker = Worker.query.get(worker_id)

    worker.first_name = request.json['first_name']
    worker.occupation_name = request.json['occupation_name']
    worker.salary_per_hour = request.json.get('salary_per_hour', worker.salary_per_hour)
    worker.middle_name = request.json.get('middle_name', worker.middle_name)
    db.session.commit()
    return jsonify('Successful')


@app.route('/workers/<int:worker_id>', methods=['DELETE'])
def delete_worker(worker_id):
    workers = Worker.query.filter_by(id=worker_id).first()
    db.session.delete(workers)
    db.session.commit()
    return jsonify({'result': True})


if __name__ == '__main__':
    app.run(debug=True)
