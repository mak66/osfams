def Map JOB_ARGS = [
    name: 'osfamicroservice',
    version: '1.0.0',
    docker_registry: 'docker-registry:5000'
]

stage('Build') {
    node('docker'){
        echo 'Building..'
        checkout scm
        sh "docker build --no-cache -t ${JOB_ARGS.docker_registry}/${JOB_ARGS.name}:${JOB_ARGS.version} ."

    }
}
stage('Deploy') {
    node('docker'){
        echo 'Deploying....'
        checkout scm
        sh 'docker images'
        sh "docker push ${JOB_ARGS.docker_registry}/${JOB_ARGS.name}:${JOB_ARGS.version}"
        sh "docker rmi ${JOB_ARGS.docker_registry}/${JOB_ARGS.name}:${JOB_ARGS.version}"
    }
}