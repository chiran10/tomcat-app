#!/bin/bash
clear

echo
echo "=== SERVICES"
kubectl get services -n enterprise-app
echo
echo
echo "=== PODS"
kubectl get pods -n enterprise-app
echo
echo
echo "=== CONFIG-MAP"
kubectl get configmap -n enterprise-app
echo
echo
echo "=== INGRESS"
kubectl get ingress -n enterprise-app
echo
echo
kubectl describe ingress enterprise-app-ingress -n enterprise-app


#echo "=== SVC"
#kubectl get svc -n enterprise-app
echo
echo
echo "=== NAMESPACES"
kubectl get namespaces
echo
echo
echo
