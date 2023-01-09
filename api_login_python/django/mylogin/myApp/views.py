from django.shortcuts import render, redirect
from django.contrib.auth.decorators import login_required
from django.contrib.auth import logout



@login_required
def home(request):
    context={}
    return render(request,"myApp/home.html", context)

def salir(request):
    logout(request)
    return redirect('/')