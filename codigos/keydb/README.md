# [KeyDB](https://docs.keydb.dev/)

Alternativa open-source ao Redis

## [Install com Docker](https://hub.docker.com/r/eqalpha/keydb)

```sh
docker pull eqalpha/keydb
```

## [Install PPA-DEB](https://docs.keydb.dev/docs/ppa-deb)
  
```sh
sudo apt install build-essential nasm autotools-dev autoconf libjemalloc-dev tcl tcl-dev uuid-dev libcurl4-openssl-dev libbz2-dev libzstd-dev liblz4-dev libsnappy-dev libssl-dev
```
```sh
echo "deb https://download.keydb.dev/open-source-dist jammy main" | sudo tee /etc/apt/sources.list.d/keydb.list
 sudo wget -O /etc/apt/trusted.gpg.d/keydb.gpg https://download.keydb.dev/open-source-dist/keyring.gpg
sudo apt update
sudo apt install keydb
```
obs: troque *jammy* pelo nome correto da sua versão do seu Ubuntu.

## Status, Start e Stop

```sh
sudo service keydb-server status
sudo service keydb-server start
sudo service keydb-server stop
```

## [Command line](https://docs.keydb.dev/docs/keydbcli)

```sh
keydb-cli 
```

