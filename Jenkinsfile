def Map JOB_ARGS = [
    name: 'osfamicroservice',
    version: '1.1.0',
    docker_registry: 'docker-registry:5000'
]

stage('Build and Push') {
    node('docker'){
        echo 'Building..'
        checkout scm
        sh "docker build --no-cache -t ${JOB_ARGS.docker_registry}/${JOB_ARGS.name}:${JOB_ARGS.version} ."
        sh "docker push ${JOB_ARGS.docker_registry}/${JOB_ARGS.name}:${JOB_ARGS.version}"

    }
}